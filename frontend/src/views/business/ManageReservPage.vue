<template>
  <div align="center">
    <img src="@/assets/reservbackimg.jpg"/>

    <manage-reserv-list :ceoBookingLists="ceoBookingLists" />
  </div>
</template>

<script>
import ManageReservList from "@/components/business/ManageReservList.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "BManageReservPage",
  components: {
    ManageReservList,
  },
  computed: {
    ...mapState(["ceoBookingLists"]),
  },
  methods: {
    ...mapActions(["fetchCeoBookingLists"]),
  },
  mounted() {
    this.fetchCeoBookingLists();
  },
};
</script>

<style scoped>

  div {
    margin-top: 50px;
    
  }

  img {
  width: 100%;
  height: 280px;
  object-fit: cover;
  /*
  background: linear-gradient(
            to bottom,
            rgba(255,255,255,0) 10%,
            rgba(255,255,255,0.5) 25%,
            rgba(255,255,255,0.7) 40%,
            rgba(255,255,255,1) 50%,
            rgba(255,255,255,1) 100%
          ), url(@/assets/hotelbackimg.jpg);
  background-repeat: no-repeat;*/
  
  }

</style>
