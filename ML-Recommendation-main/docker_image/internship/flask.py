from flask import Flask, request, jsonify
import joblib
import logging
import os

app = Flask(__name__)

# Load the trained model
model_filename = "/app/internship_random_forest_model.joblib"

if os.path.exists(model_filename):
    loaded_model = joblib.load(model_filename)
else:
    raise FileNotFoundError(f"Model file '{model_filename}' not found.")

# Set up logging
logging.basicConfig(level=logging.DEBUG)

@app.route('/internship_cluster', methods=['POST'])
def predict():
    try:
        # Get input data from JSON
        new_data = request.get_json(force=True)

        # Log the received data for debugging
        logging.debug(f"Received data: {new_data}")

        # Extract the start and end values of the interval for 'Franchise'
        start_franchise = float(new_data.get('startFranchise'))
        end_franchise = float(new_data.get('endFranchise'))

        duration_in_days = float(new_data.get('duration'))
        duration_in_months = duration_in_days / 30.44  # Assuming an average month length of 30.44 days

        # Make a prediction for each value in the interval
        predictions = []
        for franchise in range(int(start_franchise), int(end_franchise) + 1):
            prediction = loaded_model.predict([[duration_in_months, franchise]])
            predictions.append(int(prediction[0]))

        # Convert predictions to a set to get unique values
        unique_predictions = list(set(predictions))

        # Log the unique predictions for debugging
        logging.debug(unique_predictions)

        # Return the unique predictions
        return jsonify(unique_predictions)

    except Exception as e:
        # Log the error for debugging
        logging.error(f"Error: {str(e)}")
        return jsonify({'error': str(e)})
