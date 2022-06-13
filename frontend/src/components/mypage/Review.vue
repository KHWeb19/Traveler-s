<template>
  <div>
    <v-dialog v-model="loginDialog" persisten max-width="500px">
      <template v-slot:activator="{ on }">
        <v-btn color="primary" dark v-on="on">리뷰 작성</v-btn>
      </template>
      <v-card>
        <v-card-title class="headline">
          <span style=""> 리뷰작성 </span>
        </v-card-title>
        <div class="star-rating space-x-4 mx-auto">
          <input
            type="radio"
            id="5-stars"
            name="rating"
            value="5"
            v-model="ratings"
          />
          <label for="5-stars" class="star pr-4">★</label>
          <input
            type="radio"
            id="4-stars"
            name="rating"
            value="4"
            v-model="ratings"
          />
          <label for="4-stars" class="star">★</label>
          <input
            type="radio"
            id="3-stars"
            name="rating"
            value="3"
            v-model="ratings"
          />
          <label for="3-stars" class="star">★</label>
          <input
            type="radio"
            id="2-stars"
            name="rating"
            value="2"
            v-model="ratings"
          />
          <label for="2-stars" class="star">★</label>
          <input
            type="radio"
            id="1-star"
            name="rating"
            value="1"
            v-model="ratings"
          />
          <label for="1-star" class="star">★</label>
        </div>
        <div class="review_contents">
          <br />
          <br />
          <v-textarea
            outlined
            name="input-7-4"
            value="리뷰를 작성해 주세요."
          ></v-textarea>
        </div>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="teal darken-1" text @click="btnLoginClick()">
            취소
          </v-btn>
          <v-btn color="teal darken-1" text @click="btnLoginClick()">
            저장
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  mounted() {},
};
</script>
<style>
.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 2.25rem;
  line-height: 2.5rem;
  justify-content: space-around;
  padding: 0 0.2em;
  text-align: center;
  width: 5em;
}

.star-rating input {
  display: none;
}

.star-rating label {
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 2.3px;
  -webkit-text-stroke-color: #2b2a29;
  cursor: pointer;
}

.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}

.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
}
</style>
