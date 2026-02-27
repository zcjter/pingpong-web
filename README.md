# 乒乓球比赛管理系统

🏓 一个用于管理乒乓球运动员、赛事、比赛记录、排名积分及公告的Web应用。

## 项目结构

```
pingpong-web/
├── backend/                 # Spring Boot 后端
│   ├── src/main/java/com/pingpong/
│   │   ├── controller/      # REST API 控制器
│   │   ├── service/        # 业务逻辑层
│   │   ├── mapper/         # 数据访问层 (JPA Repository)
│   │   └── entity/         # 实体类
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── schema.sql      # 数据库初始化脚本
│   └── pom.xml
├── frontend/
│   └── index.html          # 前端页面
└── README.md
```

## 技术栈

- **后端**: Spring Boot 2.7.14 + Spring Data JPA + MySQL
- **前端**: 原生 HTML + CSS + JavaScript + Element UI
- **构建工具**: Maven
- **Java版本**: JDK 11

## 功能模块

1. **首页** - 最新公告、各项目实时排名TOP 3
2. **著名运动员** - 运动员列表、详情、搜索、CRUD操作
3. **赛事管理** - 赛事列表（按年份分组）、比赛记录、CRUD操作
4. **排名管理** - 年份+项目筛选、排名CRUD
5. **赛事冠军** - 赛事冠军榜展示
6. **公告管理** - 系统公告发布与管理

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

后端将在 http://localhost:8090 启动

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

### 运动员 API

| 方法   | 路径                                 | 描述                 |
| ------ | ------------------------------------ | -------------------- |
| GET    | /api/players                         | 获取所有运动员       |
| GET    | /api/players/ranking                 | 按积分排序获取运动员 |
| GET    | /api/players/{id}                    | 获取单个运动员       |
| GET    | /api/players/search?keyword=xxx      | 搜索运动员           |
| POST   | /api/players                         | 新增运动员           |
| PUT    | /api/players/{id}                    | 更新运动员           |
| DELETE | /api/players/{id}                    | 删除运动员           |
| PUT    | /api/players/{id}/ranking?points=xxx | 更新积分             |

### 赛事 API

| 方法   | 路径                     | 描述         |
| ------ | ------------------------ | ------------ |
| GET    | /api/competitions        | 获取所有赛事 |
| GET    | /api/competitions/active | 获取活跃赛事 |
| GET    | /api/competitions/{id}   | 获取单个赛事 |
| POST   | /api/competitions        | 新增赛事     |
| PUT    | /api/competitions/{id}   | 更新赛事     |
| DELETE | /api/competitions/{id}   | 删除赛事     |

### 比赛 API

| 方法   | 路径                                     | 描述             |
| ------ | ---------------------------------------- | ---------------- |
| GET    | /api/matches                             | 获取所有比赛     |
| GET    | /api/matches/{id}                        | 获取单个比赛     |
| GET    | /api/matches/status/{status}             | 按状态筛选       |
| GET    | /api/matches/competition/{competitionId} | 获取赛事下的比赛 |
| POST   | /api/matches                             | 新增比赛         |
| PUT    | /api/matches/{id}                        | 更新比赛         |
| DELETE | /api/matches/{id}                        | 删除比赛         |

### 公告 API

| 方法   | 路径                         | 描述           |
| ------ | ---------------------------- | -------------- |
| GET    | /api/announcements           | 获取所有公告   |
| GET    | /api/announcements/published | 获取已发布公告 |
| GET    | /api/announcements/{id}      | 获取单个公告   |
| POST   | /api/announcements           | 新增公告       |
| PUT    | /api/announcements/{id}      | 更新公告       |
| DELETE | /api/announcements/{id}      | 删除公告       |

### 排名 API

| 方法   | 路径                                          | 描述            |
| ------ | --------------------------------------------- | --------------- |
| GET    | /api/rankings                                 | 获取所有排名    |
| GET    | /api/rankings/years                           | 获取年份列表    |
| GET    | /api/rankings/year/{year}                     | 获取年份排名    |
| GET    | /api/rankings/year/{year}/category/{category} | 按年份+项目查询 |
| GET    | /api/rankings/category/{category}             | 按项目查询      |
| GET    | /api/rankings/{id}                            | 获取单条排名    |
| POST   | /api/rankings                                 | 新增排名        |
| PUT    | /api/rankings/{id}                            | 更新排名        |
| DELETE | /api/rankings/{id}                            | 删除排名        |

## 比赛项目类别

- 男单、女单
- 男双、女双、混双
- 男团、女团

## License

MIT
