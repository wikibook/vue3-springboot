<script setup>
let loading = true;
</script>

<template>
  <div v-if="loading">로딩 중</div>
  <div v-else>로딩 완료</div>
</template>