from kfp import dsl, components
from kfp.compiler import Compiler

# Load components from YAML file
ml_deployment_experiment = components.load_component_from_file('ml_deployment_experiment.yaml')

# Define your pipeline
@dsl.pipeline(
    name='ML Deployment Pipeline',
    description='A pipeline to deploy ML models with Flask'
)
def ml_deployment_pipeline():
    # Use the loaded component in your pipeline
    ml_deployment_experiment()

if __name__ == '__main__':
    # Compile the pipeline
    Compiler().compile(ml_deployment_pipeline, 'ml_deployment_pipeline.yaml')
