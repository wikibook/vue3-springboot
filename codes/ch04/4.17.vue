<script setup>
const parent = "fruits"
const child = "item"
</script>

<template>
  <ul :class="parent">
    <li :class="child">사과</li>
    <li :class="child">바나나</li>
    <li :class="child">딸기</li>
    <li :class="child">배</li>
  </ul>
</template>