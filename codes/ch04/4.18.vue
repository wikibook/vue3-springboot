<script setup>
const fruits = "apple avocado"
const fruitArr = ["banana", "blueberry"]
</script>

<template>
  <div :class="fruits">사과 / 아보카도</div>
  <div :class="fruitArr">바나나 / 블루베리</div>
  <div :title="fruitArr">바나나 / 블루베리</div>
</template>