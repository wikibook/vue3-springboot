<script setup>
import {reactive} from "vue";

// 반응형 상태
const state = reactive({
  player: "Kim"
});
</script>

<template>
  <div>
    <h1>{{ state.player }}</h1>
    <input type="text" v-model="state.player"/>
  </div>
</template>