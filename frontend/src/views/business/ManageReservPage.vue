<template>
  <div align="center">
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

<style scoped></style>
