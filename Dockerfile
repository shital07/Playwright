FROM mcr.microsoft.com/playwright:v1.44.1-jammy

#RUN npm install -g maven

# Install Node.js and npm
# RUN npm install -g node@16
# Update package lists and install Maven
RUN apt-get update && \
    apt-get install -y wget gnupg ca-certificates && \
    apt-get install -y openjdk-11-jdk maven

# Verify installations
RUN java -version
RUN mvn -version
RUN node -v && npm -v
# Verify installations
#RUN node -v && npm -v && mvn -v

RUN npm cache clean --force
# Install global npm packages
RUN npm install -g playwright@1.44.0

#RUN npm install
#WORKDIR /playwright_java

#COPY src /playwright_java/src
#COPY pom.xml /playwright_java/pom.xml
#COPY testng.xml /playwright_java/testng.xml

RUN mvn -version
