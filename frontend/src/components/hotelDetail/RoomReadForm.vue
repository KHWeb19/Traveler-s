<template>
    <div>
        <v-dialog resisten max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn
                        :elevation="hover ? 16:2" v-on="on" dark>
                상세보기
                </v-btn>
            </template>

                <v-card align="center">

                <!-- slide를 넣어서 객실 사진 전부를 확인할 수 있도록 한다. -->
                    <div class="slide-10d">
                        <v-container style="padding: 0px">
                            <swiper class="swiper position-relative" :options="swiperOption">
                                <swiper-slide><v-img  width="100%" height="400px" :src="require(`@/assets/hotelImg/hotel1.jpg`)"/></swiper-slide>
                                <div class="swiper-pagination" slot="pagination"></div>
                                <div class="swiper-button-prev" slot="button-prev"></div>
                                <div class="swiper-button-next" slot="button-next"></div>
                            </swiper>
                        </v-container>
                    </div>
                <br>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn>
                            닫기
                        </v-btn>
                    </v-card-actions>
                </v-card>

      </v-dialog>
    </div>
</template>

<script>
export default {
    name: 'BagInfo', 
}
</script>