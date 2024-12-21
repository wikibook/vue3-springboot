<script setup>
let loading = true;
</script>

<template>
  <div v-show="loading">로딩 중</div>
  <div v-show="!loading">로딩 완료</div>
</template>