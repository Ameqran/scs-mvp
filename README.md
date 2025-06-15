# SCS MVP Application

This repository demonstrates a minimal **Self-Contained Systems (SCS)** architecture using two independent SCSs—**Product Catalog** and **Order Management**—composed by an Angular shell via Module Federation.

---

## Table of Contents

* [Overview](#overview)
* [Architecture](#architecture)
* [Prerequisites](#prerequisites)
* [Project Structure](#project-structure)
* [Setup & Installation](#setup--installation)

  * [Backend Services](#backend-services)
  * [Frontend Applications](#frontend-applications)
* [Running the MVP](#running-the-mvp)
* [Usage](#usage)
* [Technologies](#technologies)
* [Next Steps](#next-steps)

---

## Overview

In this MVP, each SCS owns its UI, business logic, and data store:

* **Product Catalog**: Spring Boot service exposing `/api/products`, with an Angular micro-frontend.
* **Order Management**: Spring Boot service exposing `/api/orders`, with a separate Angular micro-frontend.
* **Shell**: Angular host application that composes both micro-frontends via Webpack Module Federation.

Users can navigate seamlessly between products and orders while each domain runs and deploys independently.

---

## Architecture

```
[ Shell (Angular) ]
    ↙            ↘
[ Product MFE ]  [ Order MFE ]
     |                 |
[ product-service ]  [ order-service ]
```

* **Module Federation** provides dynamic remote-loading of MFEs.
* **Reverse proxy** or host router directs `/products` and `/orders` paths to respective MFEs.
* Each Spring Boot app runs on its own port and communicates only through REST APIs.

---

## Prerequisites

* Java 17+
* Maven 3.6+
* Node.js 18+
* npm 8+ or yarn
* Angular CLI 14+

---

## Project Structure

```bash
scs-mvp/
├── product-service/   # Spring Boot Product Catalog (port 8081)
├── order-service/     # Spring Boot Order Management (port 8082)
└── frontend/
    ├── shell/         # Angular host application (port 4200)
    ├── product-mfe/   # Angular Product micro-frontend (port 4201)
    └── order-mfe/     # Angular Order micro-frontend (port 4202)
```

---

## Setup & Installation

### Backend Services

1. **product-service**

   ```bash
   cd product-service
   mvn clean install
   ```
2. **order-service**

   ```bash
   cd order-service
   mvn clean install
   ```

### Frontend Applications

Each Angular project uses Module Federation; install dependencies:

```bash
cd frontend/shell && npm install
cd frontend/product-mfe && npm install
cd frontend/order-mfe && npm install
```

---

## Running the MVP

1. **Start Product Catalog Service**

   ```bash
   cd product-service
   mvn spring-boot:run
   # running on http://localhost:8081
   ```
2. **Start Order Management Service**

   ```bash
   cd order-service
   mvn spring-boot:run
   # running on http://localhost:8082
   ```
3. **Launch Product MFE**

   ```bash
   cd frontend/product-mfe
   npm start
   # running on http://localhost:4201
   ```
4. **Launch Order MFE**

   ```bash
   cd frontend/order-mfe
   npm start
   # running on http://localhost:4202
   ```
5. **Launch Shell App**

   ```bash
   cd frontend/shell
   npm start
   # running on http://localhost:4200
   ```

---

## Usage

* Visit **[http://localhost:4200](http://localhost:4200)** in your browser.
* Use the navigation to switch between **Products** and **Orders**.
* Each view fetches from its own backend service, demonstrating independent deployment.

---

## Technologies

* **Backend**: Spring Boot, Java, Maven
* **Frontend**: Angular, Webpack Module Federation, @angular-architects/module-federation
* **Communication**: REST APIs

---

## Next Steps

* **Dockerize** each service and frontend for containerized deployment.
* **CI/CD** pipelines for automated builds and deployments.
* **Authentication** integration (e.g., Keycloak) for shared login.
* **Observability** with metrics (Prometheus) and tracing (Jaeger).

---

*Feel free to contribute or file issues!*
