Sample Spring Boot application to validate local Llama Vision LLM instance using Ollama API Server.

Prerequisites: Ollama API Server Llama Vision LLM

Postman request:

curl --location --request GET 'http://localhost:8095/api/v1/ai/generate' \
--form 'file=@"<File path>"' \
--form 'prompt="Describe about this picture with following details. 1. Background 2. Object details. 3. How to improve this picture"'
