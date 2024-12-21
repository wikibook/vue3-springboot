<script setup>
const visible = {fruit: true}
const hidden = {fruit: false}
</script>

<template>
  <div :class="visible">사과</div>
  <div :class="hidden">오이</div>
  <div :class="{fruit: true}">배</div>
</template>