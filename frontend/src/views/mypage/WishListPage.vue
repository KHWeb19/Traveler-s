<template>
  <v-container style="text-align: center">
    <div style="display: inline-block">
      <v-row>
        <v-col>
          <my-page-left-menu :userInfo="user"> </my-page-left-menu>
        </v-col>
        <v-col>
          <my-page-wish :wishLists="wishLists"></my-page-wish>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import MyPageLeftMenu from "@/components/mypage/MyPageLeftMenu.vue";
import MyPageWish from "@/components/mypage/MyPageWish.vue";
import { mapActions, mapState } from "vuex";
export default {
  name: "WishListPage",
  components: { MyPageLeftMenu, MyPageWish },
  computed: {
    ...mapState(["user", "wishLists"]),
  },
  methods: {
    ...mapActions(["setUser", "fetchWishLists"]),
  },
  mounted() {
    this.setUser();
    this.fetchWishLists();
  },
};
</script>

<style></style>
