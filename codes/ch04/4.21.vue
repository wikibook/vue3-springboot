<script setup>
// 스타일을 객체로 입력
const rect = {
  background: "red",
  width: "200px",
  height: "100px"
}
</script>

<template>
  <div :style="rect"></div>
</template>