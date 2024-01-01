## 子路由
```
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children: [
      {
        path: 'about',
        name: 'About',
        component: About
      },
      {
        path: 'contact',
        name: 'Contact',
        component: Contact
      }
    ]
  }
];
```

## 路由传参

```
const router = createRouter({
  routes: [
    {
      path: '/user/:id',
      component: UserProfile,
      // ...
    }
  ]
});

```

## 跳转分类
1. 刷新
2. 前进
3. 后退
4. hash(带# 符号)
5. history(不带# 符号)