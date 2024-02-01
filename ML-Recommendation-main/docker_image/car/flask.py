from flask import Flask, request, jsonify
import joblib
import logging
import os

app = Flask(__name__)

# Load the trained model
model_filename = "/app/car_random_forest_model.joblib"

if os.path.exists(model_filename):
    loaded_model = joblib.load(model_filename)
else:
    raise FileNotFoundError(f"Model file '{model_filename}' not found.")

# Set up logging
logging.basicConfig(level=logging.DEBUG)

@app.route('/car_cluster', methods=['POST'])
def predict():
    try:
        # Get input data from JSON
        new_data = request.get_json(force=True)

        # Log the received data for debugging
        logging.debug(f"Received data: {new_data}")

        # Validate input data
        if 'mileage' not in new_data or 'age' not in new_data:
            raise ValueError("Input data must contain 'Mileage' and 'Age'.")

        # Convert input data to float and int
        mileage = float(new_data['mileage'])
        age = int(new_data['age'])  # Convert 'age' to int

        # Make a prediction
        prediction = loaded_model.predict([[mileage, age]])

        # Log the prediction for debugging
        logging.debug(prediction)

        # Convert the prediction to int before returning
        serialized_prediction = int(prediction[0])

        # Return the prediction
        return jsonify(serialized_prediction)

    except ValueError as ve:
        # Log the validation error for debugging
        logging.error(f"Validation Error: {str(ve)}")
        return jsonify({'error': str(ve), 'message': 'Invalid input data'})

    except Exception as e:
        # Log other errors for debugging
        logging.error(f"Error: {str(e)}")
        return jsonify({'error': str(e)})
