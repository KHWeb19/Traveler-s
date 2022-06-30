<template>
  <v-container style="text-align: center">
    <div style="display: inline-block">
      <v-row>
        <v-col>
          <my-page-left-menu-vue :userInfo="user" />
        </v-col>
        <v-col>
          <my-page-profile-form
            :userInfo="user"
            @updatePassword="updatePassword"
          />
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import MyPageProfileForm from "@/components/mypage/MyPageProfileForm.vue";
import MyPageLeftMenuVue from "@/components/mypage/MyPageLeftMenu.vue";
import { mapActions, mapState } from "vuex";
import axios from "axios";
export default {
  components: {
    MyPageProfileForm,
    MyPageLeftMenuVue,
  },

  computed: {
    ...mapState(["user"]),
  },
  methods: {
    ...mapActions(["setUser"]),
    updatePassword(password) {
      const params = new URLSearchParams();
      params.append("password", password);
      axios
        .post("http://localhost:7777/updatePassword", params)
        .then(() => alert("변경성공"));
    },
  },
  mounted() {
    this.setUser();
  },
};
</script>

<style></style>
