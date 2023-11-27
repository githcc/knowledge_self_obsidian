在 Vuex 中，`actions` 用于处理异步操作、封装复杂逻辑或者处理一系列的 mutations。它们类似于 mutations，但是 actions 可以包含异步操作，并且可以通过调用 `commit` 来触发 mutations。

### 在 Vuex 中定义和使用 Actions

定义 actions 很简单，可以在 Vuex store 的配置中的 `actions` 对象中定义多个 action：

```javascript
import { createStore } from 'vuex';

const store = createStore({
  state: {
    count: 0
  },
  mutations: {
    increment(state) {
      state.count++;
    }
  },
  actions: {
    // 定义一个名为 incrementAsync 的 action
    incrementAsync(context) {
      // 在这里进行异步操作，然后提交 mutation
      setTimeout(() => {
        context.commit('increment');
      }, 1000);
    }
  }
});
```

在组件中，可以通过 `$store.dispatch` 来触发执行 actions：

```vue
<template>
  <div>
    <p>Count: {{ $store.state.count }}</p>
    <button @click="incrementAsync">Increment Async</button>
  </div>
</template>

<script>
export default {
  methods: {
    incrementAsync() {
      // 调用 actions 中定义的 incrementAsync 方法
      this.$store.dispatch('incrementAsync');
    }
  }
};
</script>
```

在这个例子中，当点击按钮时，调用了名为 `incrementAsync` 的 action。这个 action 中包含一个异步操作（`setTimeout`），然后通过 `context.commit('increment')` 触发了对应的 mutation。

使用 actions 可以使得 Vuex 中的逻辑更加模块化和可维护，尤其适用于处理异步操作、复杂逻辑或者多个 mutations 的情况。