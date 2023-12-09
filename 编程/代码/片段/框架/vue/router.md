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
