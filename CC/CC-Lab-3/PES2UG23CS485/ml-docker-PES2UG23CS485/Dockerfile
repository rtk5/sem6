# Step 1: Specify the base image (use Python slim version)
FROM python:3.9-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the application file into the container
COPY app.py ./

# Step 4: Copy the ML model file into the container
COPY spam_classifier_model.pkl ./

# Step 5: Copy the vectorizer file into the container
COPY tfidf_vectorizer.pkl ./

# Step 6: Copy the HTML templates folder
COPY templates ./templates

# Step 7: Install required Python libraries (Flask, scikit-learn, joblib)
RUN pip install --no-cache-dir flask scikit-learn joblib

# Step 8: Expose the port used by the Flask app
EXPOSE 5000

# Step 9: Command to start the application when container runs
CMD ["python", "app.py"]
