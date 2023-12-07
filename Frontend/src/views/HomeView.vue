<template>
  <div class="home">
    <div class="card">
      <h2>Välkommen till</h2>
      <div class="img-logo">
        <img src="../assets/logo-black.png" alt="logo" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  components: {},
};
</script>

<style>
@font-face {
  font-family: "Mansalva";
  src: url("../assets/Mansalva-Regular.ttf");
}
.home {
  background: #dedbd3;
  height: 100%;
  width: 100%;
}
h2 {
  font-family: "Mansalva";
  font-size: 50px;
}
</style>
