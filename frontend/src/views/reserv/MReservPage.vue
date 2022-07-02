<template>
    <div class="container" align="center">
        <div class="row">
          <m-reserv-form/>      
        </div>
    </div>
</template>

<script>
import MReservForm from '@/components/reserv/MReservForm.vue'

export default {
  components: { MReservForm },
    name: 'MReservPage',
}
</script>

<style scoped>

</style>