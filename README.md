# 乒乓球比赛管理系统

## 项目结构

```
pingpong-web/
├── backend/                 # Spring Boot 后端
│   ├── src/main/java/com/pingpong/
│   │   ├── controller/     # REST API 控制器
│   │   ├── service/       # 业务逻辑层
│   │   ├── mapper/        # 数据访问层
│   │   └── entity/        # 实体类
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── schema.sql     # 数据库初始化脚本
│   └── pom.xml
└── frontend/               # Vue.js 前端
    └── index.html         # 单页应用
```

## 技术栈

- 后端: Spring Boot 2.7 + JPA + MySQL
- 前端: HTML + Vue 3 + Element UI

## 功能模块

1. **首页** - 显示公告和排名TOP5
2. **运动员管理** - CRUD操作，支持搜索
3. **比赛管理** - 记录比赛成绩
4. **排名榜** - 按积分排序

## 快速启动

### 1. 数据库准备

```sql
-- 登录MySQL后执行
CREATE DATABASE pingpong;
USE pingpong;
-- 或者直接运行 backend/src/main/resources/schema.sql
```

### 2. 修改数据库配置

编辑 `backend/src/main/resources/application.yml`，修改数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/pingpong
    username: root      # 改为你的用户名
    password: root      # 改为你的密码
```

### 3. 启动后端

```bash
cd backend
mvn spring-boot:run
```

后端将在 http://localhost:8080 启动

### 4. 启动前端

直接用浏览器打开 `frontend/index.html`

或者使用静态服务器：

```bash
# 如果安装了 Python
cd frontend
python -m http.server 8081
```

然后访问 http://localhost:8081

## API 接口

### 运动员
- `GET /api/players` - 获取所有运动员
- `GET /api/players/ranking` - 按排名获取运动员
- `GET /api/players/{id}` - 获取单个运动员
- `GET /api/players/search?keyword=xxx` - 搜索运动员
- `POST /api/players` - 添加运动员
- `PUT /api/players/{id}` - 更新运动员
- `DELETE /api/players/{id}` - 删除运动员

### 比赛
- `GET /api/matches` - 获取所有比赛
- `GET /api/matches/{id}` - 获取比赛详情
- `GET /api/matches/player/{playerId}` - 获取运动员的比赛
- `POST /api/matches` - 添加比赛
- `PUT /api/matches/{id}` - 更新比赛
- `DELETE /api/matches/{id}` - 删除比赛

### 公告
- `GET /api/announcements` - 获取所有公告
- `GET /api/announcements/published` - 获取已发布公告
- `POST /api/announcements` - 添加公告
- `PUT /api/announcements/{id}` - 更新公告
- `DELETE /api/announcements/{id}` - 删除公告
