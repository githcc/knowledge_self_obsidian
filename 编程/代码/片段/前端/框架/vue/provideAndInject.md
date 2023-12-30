 在 Vue 3 中，`provide` 和 `inject` 是用于父子组件间传递数据的一种高级方法。它们允许祖先组件提供数据，然后在后代组件中使用 `inject` 来接收这些数据。

### `provide` 和 `inject` 的用法

#### 1. `provide`

`provide` 被用于祖先组件中，用于提供数据或方法给子孙组件。它可以是任何数据类型，包括对象、函数等。

```vue
<script>
import { provide } from 'vue';

export default {
  setup() {
    const sharedData = 'Hello from parent!';

    provide('sharedData', sharedData);

    return {};
  }
};
</script>
```

#### 2. `inject`

`inject` 被用于子孙组件中，用于接收通过 `provide` 提供的数据或方法。在组件中使用 `inject` 来声明你需要注入的数据。

```vue
<script>
import { inject } from 'vue';

export default {
  setup() {
    const sharedData = inject('sharedData');

    return {
      sharedData
    };
  }
};
</script>
```

### 注意事项

- 使用 `provide` 和 `inject` 需要在组件的 `setup()` 函数中使用。
- `provide` 和 `inject` 主要用于提供全局配置、状态管理、或者一些全局共享的方法，不建议过多地使用它们传递大量的数据。
- 当数据或方法发生变化时，`inject` 注入的值会随之更新。但请注意，这并不会触发组件的重新渲染，所以你可能需要自己处理响应式更新。
- 为了更好地进行类型推断，可以使用 TypeScript 来为 `inject` 提供类型声明。

这种提供和注入的方式是 Vue 3 中一种方便的跨组件传递数据的方法，但在使用时要注意遵循适当的使用场景和最佳实践。