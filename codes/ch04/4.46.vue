<script setup>
import {onUpdated, reactive} from "vue";

// 반응형 상태
const state = reactive({
  message: "Hello!"
});

onUpdated(() => {
  // OK
  console.log(document.getElementById('btn').innerText)
});
</script>

<template>
  <button id="btn" @click="state.message='Aloha!'">{{ state.message }}</button>
</template>