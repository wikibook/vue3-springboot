<script setup>
// 팔 굽혀 펴기 개수
let pushUp = 0;

// 윗몸 일으키기 개수
let sitUp = 0;

// 팔 굽혀 펴기 개수 증가
const increasePushUp = () => {
  pushUp++;
  console.log(`pushUp: ${pushUp}`);
};

// 윗몸 일으키기 개수 증가
const increaseSitUp = () => {
  sitUp++;
  console.log(`sitUp: ${sitUp}`);
};
</script>

<template>
  <div>
    <h1>체력 검사</h1>
    <br/>
    <hr/>
    <ul>
      <li id="pushUp">팔 굽혀 펴기: {{ pushUp }}</li>
      <li id="sitUp">윗몸 일으키기: {{ sitUp }}</li>
    </ul>
    <hr/>
    <br/>
    <button @click="increasePushUp()">팔 굽혀 펴기 증가</button>
    <button @click="increaseSitUp()">윗몸 일으키기 증가</button>
  </div>
</template>