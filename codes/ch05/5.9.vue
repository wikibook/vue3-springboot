<template>
  <div class="app">
    <div class="container py-4"> <!-- ①, ② -->
      <!-- 헤더 -->
      <header class="pb-4 mb-4 border-bottom"> <!-- ②, ③, ④ -->
        <router-link to="/" class="text-dark text-decoration-none"> <!-- ⑤, ⑥ -->
          <b class="fs-4">Memo Application</b> <!-- ⑦ -->
        </router-link>
      </header>
      <!-- 메인 -->
      <main>
        <!-- 라우터 뷰 -->
        <router-view></router-view>
      </main>
      <!-- 푸터 -->
      <footer class="pt-4 mt-4 border-top">&copy; 2024. Memo. All rights reserved.</footer> <!-- ②, ③, ④ -->
    </div>
  </div>
</template>