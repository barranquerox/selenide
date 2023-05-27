FROM maven:latest

# Copy your project files into the image
COPY . /app

# Change working directory
WORKDIR /app

# Update the system packages
RUN apt-get update

# Install openssl and ca-certificates
RUN apt-get install -y openssl ca-certificates

# Download the SSL certificate from the Maven repository and import it into the Java keystore
RUN echo -n | openssl s_client -connect repo.maven.apache.org:443 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > /tmp/repo.maven.apache.org.crt \
    && keytool -import -trustcacerts -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit -noprompt -alias repo.maven.apache.org -file /tmp/repo.maven.apache.org.crt \
    && rm /tmp/repo.maven.apache.org.crt

# Run Maven to resolve dependencies and compile the code
RUN mvn compile
