<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <v-card class="right">
      <div style="display: flex; justify-content: center">
        <v-form ref="form" lazy-validation> </v-form>
      </div>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "MyPageWish",
};
</script>

<style scoped>
.left_menu {
  width: 200px;
  height: 848px;
  border-right-width: 3px;
  border-right-color: rgba(64, 64, 64);
  border-right-style: dotted;
  padding: 3%;
  background: rgba(64, 64, 64);
  color: white;
}
.proimg {
  width: 150px;
}

.col1 {
  background: rgb(224, 224, 224);
}
.btn2 {
  background: rgb(224, 224, 224);
}

.right {
  width: 600px;
  height: 848px;
  background: rgb(250, 250, 250);
}

ul a {
  color: inherit;
}

ul {
  list-style: none;
  margin: 20% 0 0 0;
}

a {
  text-decoration: none;
}
</style>
