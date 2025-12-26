# WanMall

WanMall is a modern e-commerce platform built with the Aero framework. It provides a complete online shopping experience with user management, product browsing, shopping cart, order processing, and payment features.

## 🌐 Language

- [English README](README.md)
- [中文说明](README_zh.md)

## Features

- User registration and authentication system
- Product browsing and searching
- Shopping cart functionality
- Order creation and payment processing
- User profile and address management
- Product reviews and comments
- Favorite items management

## Technology Stack

- **Framework**: [Aero Framework](https://github.com/livenne/aero) 1.0.3
- **Language**: Java
- **Database**: MySQL (JDBC)
- **Build Tool**: Gradle
- **Architecture**: MVC with layered architecture (Controller, Service, Repository)
- **Dependency Injection**: Built-in Aero DI system
- **ORM**: Custom repository pattern implementation

## Architecture

WanMall follows a clean architecture pattern with the following layers:

- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Handles database operations
- **Model Layer**: Contains DTOs, Entities, and VO objects

### Modules

- **Auth Module**: User authentication and registration
- **User Module**: Profile management, addresses, favorites
- **Goods Module**: Product browsing, searching, categorization
- **Shop Module**: Shopping cart, order processing, payment

## Setup and Installation

1. Clone the repository
2. Install MySQL and create a database named `wanmall`
3. Update database credentials in `src/main/resources/application.properties`:
   ```
   database.url=jdbc:mysql://localhost:3306/wanmall
   database.driver=com.mysql.cj.jdbc.Driver
   database.username=your_username
   database.password=your_password
   server.port=8080
   ```
4. Build the project:
   ```
   ./gradlew build
   ```
5. Run the application:
   ```
   java -jar build/libs/wanmall-1.0-SNAPSHOT-all.jar
   ```

## API Endpoints

### Authentication
- `POST /auth/login` - User login
- `POST /auth/register` - User registration

### Goods
- `GET /goods/recommend` - Get recommended products
- `GET /goods/get/{id}` - Get product by ID
- `GET /goods/get/{id}/comments` - Get product comments
- `GET /goods/search?kw={keyword}` - Search products
- `GET /goods/classify?type={type}` - Get products by category

### User
- `POST /user/addr/setdef/{id}` - Set default address
- `POST /user/addr/add` - Add new address
- `POST /user/addr/remove/{id}` - Remove address
- `POST /user/addr/update/{id}` - Update address
- `GET /user/addr` - Get user addresses
- `POST /user/nickname/update` - Update nickname
- `POST /user/password/update` - Update password
- `POST /user/avatar/update` - Update avatar

### Shop
- `POST /shop/cart/add/{id}` - Add item to cart
- `POST /shop/cart/sub/{id}` - Remove one item from cart
- `POST /shop/cart/remove/{id}` - Remove all items of a product from cart
- `POST /shop/order/create` - Create order
- `POST /shop/order/pay` - Pay for order

## Database Schema

The application requires a MySQL database with the following main tables:
- Users (user information)
- Goods (product information)
- UserCart (shopping cart entries)
- Orders (order information)
- GoodsComments (product reviews)
- UserAddr (user addresses)

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE](LICENSE) file for details.

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## About Aero Framework

WanMall is built with the [Aero Framework](https://github.com/livenne/aero), a lightweight Java web framework that provides:

- Annotation-based routing
- Dependency injection
- ORM capabilities
- Request/response handling
- Modular architecture support

For more information about the framework, please check the [Aero repository](https://github.com/livenne/aero).