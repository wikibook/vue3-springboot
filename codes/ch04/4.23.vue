<script setup>
let loading = true;
</script>

<template>
  <template v-if="loading">로딩 중</template> <!-- 여기 -->
  <template v-else>로딩 완료</template> <!-- 여기 -->
</template>