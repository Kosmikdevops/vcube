# Use the official Tomcat image as the base image
FROM tomcat:9.0

# Set environment variables for MySQL connection (adjust based on your app's requirements)
ENV DB_HOST=mysql \
    DB_PORT=3306 \
    DB_NAME=mydatabase \
    DB_USER=myuser \
    DB_PASSWORD=root

# Copy your application's WAR file to the Tomcat webapps directory
COPY target/VCubeDataManagmentSoftware-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]

