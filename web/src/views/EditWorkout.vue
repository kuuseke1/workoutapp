<template>
    <div class="wrapper">
        <Navigation activeTab="EditWorkout"></Navigation>
        <div class="login-box">
            <div class="form" id="foo">
                <form class="login-form" @submit.prevent="editExercise">
                    <h3> {{ msg }} </h3>
                    <p class="msg"><b>Edit exercise:</b><br></p>
                    <label>
                        <select class="form-control" name="name" v-model="name">
                            <option value="Push-ups">Push-ups</option>
                            <option value="Burpees">Burpees</option>
                            <option value="Squats">Squats</option>
                            <option value="Crunches">Crunches</option>
                            <option value="Pull-ups">Pull-ups</option>
                            <option value="Dips">Dips</option>
                        </select>
                    </label><br>
                    <p class="msg"><b>Edit repetitions:</b><br></p>
                    <input type="number" name="repetitions" min="1" max="500" v-model="repetitions">
                    <br>
                    <br>
                    <input type="submit" value="Edit exercise" class="btn">
                    <br>

                    <p class="msg">Name: {{ name }}</p>
                    <p class="msg">Repetitions: {{ repetitions }}</p>
                    <!--<p class="msg">Picked: {{ users }}</p>-->
                </form>
                <br>
                <button type="submit" @click="editWorkout">Edit Workout</button>
            </div>
        </div>
        <div class="back">
            <router-link class="btnn btn" :to="{path: '/workouts'}">Back</router-link>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import Navigation from '../components/Navigation.vue';

    export default {
        name: "EditWorkout",
        props: {
            item: Object,
        },
        components: {
            Navigation,
        },
        data() {
            return {
                name: '',
                repetitions: '',
                msg: '',
                users: [],
            }
        },
        methods: {
            editExercise: function () {
                this.users.push({
                    name: this.name,
                    repetitions: this.repetitions || 1,
                }).then(this.msg = "Editing...",
                    this.name = '',
                    this.repetitions = '');

            },
            editWorkout: function () {
                axios
                    .put('http://localhost:8080/workouts/' + this.$route.params.itemId, {
                        exercises: this.users,
                        timestamp: Math.round(+new Date() / 1000),
                    })

                    .then((response => {
                        if (response.status === 200) {
                            this.msg = "Workout was changed";
                        } else {
                            this.msg = "Something went wrong";
                        }
                    }))
                    .catch(error => {
                        if (error) {
                            var x = document.getElementById("foo");
                            x.style.display = "none";
                            this.msg = "Workout was changed"
                        }
                    });
                this.name = '';
                this.repetitions = '';
                this.users = [];
            }

            ,
        }
    };
</script>

<style scoped>
    .wrapper {
        height: 100vh;
        margin: auto;
        background-size: cover;
        background: rgb(0, 0, 0);
        background: rgba(0, 0, 0, 0.5) url("../assets/pic.jpg") no-repeat top;
    }

    .login-box {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 400px;
    }

    .form {
        position: relative;
        /*background: rgba(255, 255, 255, 0.41);*/
        background: rgba(112, 112, 112, 0.6);
        margin: 0 auto 100px;
        padding: 40px;
        text-align: center;
        /*max-width: 360px;*/
        /*box-shadow: 5px 8px 8px 5px rgba(134, 63, 76, 0.75);*/
        /*horiz, vert, blur radius, spread radius*/
        border-radius: 15px;
        /*background: #868686;*/
        border: solid rgba(255, 255, 255, 0.31);
    }

    .form .msg {
        color: rgb(0, 0, 0);
        font-size: 25px;
    }

    h3 {
        color: #d30000;
    }

    button {
        display: inline-block;
        border: solid 5px black;
        background: #555;
        color: #fff;
        padding: 7px 15px;
        cursor: pointer;
    }

    input {
        text-align: center;
        font-size: 15px;
    }

    button:hover {
        background: #666;
    }

    .btnn {
        width: 200px;
        border-radius: 20px;
        margin: 3rem;
    }

</style>
