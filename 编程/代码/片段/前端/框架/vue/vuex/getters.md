在 Vuex 中，`getters` 类似于组件中的计算属性，用于对 `state` 中的数据进行加工处理。它允许你在 store 中对 state 进行预处理后再提供给组件使用，同时还可以对 state 中的数据进行缓存，避免多次计算。

### 在 Vuex 中定义和使用 Getters

定义 getters 很简单，可以在 Vuex store 的配置中的 `getters` 对象中定义多个 getter：

```javascript
import { createStore } from 'vuex';

const store = createStore({
  state: {
    todos: [
      { id: 1, text: 'Todo 1', done: true },
      { id: 2, text: 'Todo 2', done: false },
      { id: 3, text: 'Todo 3', done: true }
    ]
  },
  getters: {
    doneTodos: state => {
      return state.todos.filter(todo => todo.done);
    },
    getTodoById: state => id => {
      return state.todos.find(todo => todo.id === id);
    }
  }
});
```

在这个例子中，`doneTodos` 是一个 getter，它返回 `state.todos` 中已完成的任务数组。`getTodoById` 是一个带参数的 getter，它接收一个 id 参数并返回对应的任务对象。

在组件中可以通过 `$store.getters` 来访问这些 getters：

```vue
<template>
  <div>
    <ul>
      <li v-for="todo in doneTodos" :key="todo.id">
        {{ todo.text }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  computed: {
    doneTodos() {
      return this.$store.getters.doneTodos;
    }
  }
};
</script>
```

在这个示例中，组件中通过 `$store.getters.doneTodos` 获取了已完成的任务列表，并在模板中展示了这些任务的文本。注意，在组件中使用 `doneTodos` 时，它实际上是作为计算属性被访问的，这样可以在组件重新渲染时获取最新的值。