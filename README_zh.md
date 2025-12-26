# WanMall

WanMall 是一个基于 Aero 框架构建的现代化电子商务平台。它提供了完整的在线购物体验，包括用户管理、商品浏览、购物车、订单处理和支付功能。

## 🌐 Language

- [English README](README.md)
- [中文说明](README_zh.md)

## 功能特性

- 用户注册和身份验证系统
- 商品浏览和搜索
- 购物车功能
- 订单创建和支付处理
- 用户资料和地址管理
- 商品评价和评论
- 收藏夹管理

## 技术栈

- **框架**: [Aero Framework](https://github.com/livenne/aero) 1.0.3
- **语言**: Java
- **数据库**: MySQL (JDBC)
- **构建工具**: Gradle
- **架构**: MVC 分层架构 (控制器、服务、仓库)
- **依赖注入**: 内置 Aero DI 系统
- **ORM**: 自定义仓库模式实现

## 架构

WanMall 遵循整洁架构模式，包含以下层次：

- **控制器层**: 处理 HTTP 请求和响应
- **服务层**: 包含业务逻辑
- **仓库层**: 处理数据库操作
- **模型层**: 包含 DTO、实体和 VO 对象

### 模块

- **认证模块**: 用户身份验证和注册
- **用户模块**: 资料管理、地址、收藏夹
- **商品模块**: 商品浏览、搜索、分类
- **商店模块**: 购物车、订单处理、支付

## 安装和设置

1. 克隆仓库
2. 安装 MySQL 并创建名为 `wanmall` 的数据库
3. 在 `src/main/resources/application.properties` 中更新数据库凭据：
   ```
   database.url=jdbc:mysql://localhost:3306/wanmall
   database.driver=com.mysql.cj.jdbc.Driver
   database.username=your_username
   database.password=your_password
   server.port=8080
   ```
4. 构建项目：
   ```
   ./gradlew build
   ```
5. 运行应用程序：
   ```
   java -jar build/libs/wanmall-1.0-SNAPSHOT-all.jar
   ```

## API 端点

### 认证
- `POST /auth/login` - 用户登录
- `POST /auth/register` - 用户注册

### 商品
- `GET /goods/recommend` - 获取推荐商品
- `GET /goods/get/{id}` - 根据 ID 获取商品
- `GET /goods/get/{id}/comments` - 获取商品评论
- `GET /goods/search?kw={keyword}` - 搜索商品
- `GET /goods/classify?type={type}` - 按类别获取商品

### 用户
- `POST /user/addr/setdef/{id}` - 设置默认地址
- `POST /user/addr/add` - 添加新地址
- `POST /user/addr/remove/{id}` - 删除地址
- `POST /user/addr/update/{id}` - 更新地址
- `GET /user/addr` - 获取用户地址
- `POST /user/nickname/update` - 更新昵称
- `POST /user/password/update` - 更新密码
- `POST /user/avatar/update` - 更新头像

### 商店
- `POST /shop/cart/add/{id}` - 添加商品到购物车
- `POST /shop/cart/sub/{id}` - 从购物车移除一个商品
- `POST /shop/cart/remove/{id}` - 从购物车移除全部某商品
- `POST /shop/order/create` - 创建订单
- `POST /shop/order/pay` - 支付订单

## 数据库结构

应用程序需要一个 MySQL 数据库，包含以下主要表：
- Users (用户信息)
- Goods (商品信息)
- UserCart (购物车条目)
- Orders (订单信息)
- GoodsComments (商品评论)
- UserAddr (用户地址)

## 许可证

本项目根据 Apache 2.0 许可证授权 - 有关详细信息，请参阅 [LICENSE](LICENSE) 文件。

## 贡献

1. Fork 仓库
2. 创建功能分支 (`git checkout -b feature/amazing-feature`)
3. 提交更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 开启 Pull Request

## 关于 Aero 框架

WanMall 使用 [Aero 框架](https://github.com/livenne/aero) 构建，这是一个轻量级 Java Web 框架，提供：

- 基于注解的路由
- 依赖注入
- ORM 功能
- 请求/响应处理
- 模块化架构支持

有关框架的更多信息，请查看 [Aero 仓库](https://github.com/livenne/aero)。