<script setup>
import Tire from "@/components/Tire.vue";
</script>

<template>
  <div class="rear-wheel">
    <span>REAR WHEEL</span>
    <Tire/>
  </div>
</template>

<style scoped>
.rear-wheel {
  border: 1px solid black;
  border-radius: 50%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 150px;
  height: 150px;
}
</style>