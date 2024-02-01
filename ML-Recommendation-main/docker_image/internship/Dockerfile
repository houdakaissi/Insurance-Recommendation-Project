# Use an official Python runtime as a parent image
FROM python

# Set environment variables
ENV PYTHONUNBUFFERED 1

# Create and set the working directory
WORKDIR /app

# Copy only the necessary files
COPY flask.py internship_random_forest_model.joblib requirements.txt /app/

# Upgrade pip and install needed packages
RUN pip install --no-cache-dir -r requirements.txt 

# Make port 5000 available to the world outside this container
EXPOSE 5003

# Specify the command to run your script (modify as needed)
CMD ["gunicorn", "-w", "4", "-b", "0.0.0.0:5003", "flask:app"]
