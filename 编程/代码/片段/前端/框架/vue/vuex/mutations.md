在 Vuex 中，`mutations` 用于修改 `state` 中的数据。它们是 Vuex 中唯一允许修改状态的地方。每个 mutation 都有一个字符串类型的事件（`type`）和一个回调函数，该函数接受 `state` 作为第一个参数，可以传递额外的参数来进行状态的变更。

### 在 Vuex 中定义和使用 Mutations

定义 mutations 很简单，可以在 Vuex store 的配置中的 `mutations` 对象中定义多个 mutation：

```javascript
import { createStore } from 'vuex';

const store = createStore({
  state: {
    count: 0
  },
  mutations: {
    increment(state) {
      state.count++;
    },
    incrementBy(state, value) {
      state.count += value;
    }
  }
});
```

在这个例子中，`increment` 和 `incrementBy` 是两个 mutations。`increment` 用于使 `count` 加一，而 `incrementBy` 则接受一个额外的参数 `value`，并将 `count` 加上这个值。

在组件中可以通过 `$store.commit` 来触发执行 mutations：

```vue
<template>
  <div>
    <p>Count: {{ $store.state.count }}</p>
    <button @click="increment">Increment</button>
    <button @click="incrementBy(5)">Increment by 5</button>
  </div>
</template>

<script>
export default {
  methods: {
    increment() {
      this.$store.commit('increment');
    },
    incrementBy(value) {
      this.$store.commit('incrementBy', value);
    }
  }
};
</script>
```

这个示例中，通过 `this.$store.commit('increment')` 和 `this.$store.commit('incrementBy', value)` 来触发执行相应的 mutations。

mutations 中的操作应该是同步的，不要在 mutations 中执行异步操作。异步操作应该放在 actions 中执行，然后通过 commit 触发 mutations。这样有利于追踪状态变更的来源和异步操作的管理。