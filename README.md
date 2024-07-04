# Highway Ticket Management System

This repository contains the Highway Ticket Management System, which includes services for managing users, vehicles, tickets, and payments.

## Postman Collection

You can find the Postman collection for this project [here](./Highway-Ticket-Management.postman_collection.json).

## Endpoints

### User Service
- **User Health Check**
  - **Method**: GET
  - **URL**: `http://localhost:8081/system/api/v1/user/health`

- **Create User**
  - **Method**: POST
  - **URL**: `http://localhost:8081/system/api/v1/user`
  - **Body**:
    ```json
    {
      "username": "thisara",
      "password": "1234",
      "name": "thisara",
      "userId": "exampleUserId",
      "role": "USER"
    }
    ```

- **Verify User**
  - **Method**: GET
  - **URL**: `http://localhost:8081/system/api/v1/user/verify`
  - **Body**:
    ```json
    {
      "username": "thisara",
      "password": "1234",
      "name": "thisara",
      "userId": "exampleUserId",
      "role": "USER"
    }
    ```

- **Update User**
  - **Method**: PUT
  - **URL**: `http://localhost:8081/system/api/v1/user/{userId}`
  - **Body**:
    ```json
    {
      "username": "thisara",
      "password": "1234",
      "name": "thisara",
      "userId": "4e454910-6b07-4cfd-9c28-28d649607a2d",
      "role": "USER"
    }
    ```

### Vehicle Service
- **Vehicle Health Check**
  - **Method**: GET
  - **URL**: `http://localhost:8082/system/api/v1/vehicle/health`

- **Get Vehicle**
  - **Method**: GET
  - **URL**: `http://localhost:8082/system/api/v1/vehicle/{vehicleId}`

- **Create Vehicle**
  - **Method**: POST
  - **URL**: `http://localhost:8082/system/api/v1/vehicle`
  - **Body**:
    ```json
    {
      "vehicleId": "ABC1231",
      "vehicleOwnerName": "Thisara",
      "vehicleOwnerNic": "123456789v"
    }
    ```

- **Update Vehicle**
  - **Method**: PUT
  - **URL**: `http://localhost:8082/system/api/v1/vehicle/{vehicleId}`
  - **Body**:
    ```json
    {
      "vehicleId": "ABC1231",
      "vehicleOwnerName": "kaviiii",
      "vehicleOwnerNic": "123456789v"
    }
    ```

### Ticket Service
- **Ticket Health Check**
  - **Method**: GET
  - **URL**: `http://localhost:8083/system/api/v1/ticket/health`

- **Get Ticket**
  - **Method**: GET
  - **URL**: `http://localhost:8083/system/api/v1/ticket/{ticketId}`

- **Create Ticket**
  - **Method**: POST
  - **URL**: `http://localhost:8083/system/api/v1/ticket`
  - **Body**:
    ```json
    {
      "ticketId": "2",
      "travelDate": "2024-07-05T12:00:00Z",
      "ticketPrice": 100.50,
      "departureLocation": "Colombo",
      "arrivalLocation": "Kandy",
      "ticketStatus": "PENDING",
      "assignedVehicleId": "VEH12345",
      "bookingUserId": "USR67890"
    }
    ```

- **Update Ticket**
  - **Method**: PUT
  - **URL**: `http://localhost:8083/system/api/v1/ticket/{ticketId}`
  - **Body**:
    ```json
    {
      "ticketId": "67e5cfb6-6c2f-4071-91fa-de159551cbb2",
      "travelDate": "2024-07-05T12:00:00Z",
      "ticketPrice": 100.50,
      "departureLocation": "Colombo",
      "arrivalLocation": "Kandy",
      "ticketStatus": "PENDING",
      "assignedVehicleId": "VEH12345",
      "bookingUserId": "USR67890"
    }
    ```

### Payment Service
- **Payment Health Check**
  - **Method**: GET
  - **URL**: `http://localhost:8084/system/api/v1/payment/health`

- **Create Payment**
  - **Method**: POST
  - **URL**: `http://localhost:8084/system/api/v1/payment`
  - **Body**:
    ```json
    {
      "paymentId": "PAY000001",
      "date": "2024-07-04T12:00:00Z",
      "ticketId": "67e5cfb6-6c2f-4071-91fa-de159551cbb2",
      "userId": "4e454910-6b07-4cfd-9c28-28d649607a2d",
      "vehicleId": "ABC1231"
    }
    ```

## How to Use

1. Clone the repository:
    ```bash
    git clone https://github.com/Thisarakavishka/Highway-Ticket-Management-Back-End.git
    ```
2. Navigate to the project directory:
    ```bash
    cd yourrepository
    ```
3. Import the Postman collection:
    - Open Postman.
    - Click on the `Import` button.
    - Select `Upload Files`.
    - Choose the `postman-collection.json` file from the project directory.

4. Use the endpoints as per the details provided in the collection.

For more information, refer to the [Postman documentation](https://learning.postman.com/docs/getting-started/introduction/).
