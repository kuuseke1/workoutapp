<template>

    <div class="wrapper">
        <Navigation activeTab="AddExercise"/>
        <div class="login-box">
            <div class="form">
                <form class="login-form" @submit.prevent="addExercise">
                    <h3> {{ msg }} </h3>
                    <p class="msg">Select exercise:<br></p>
                    <label>
                        <select name="name" v-model="name">
                            <option value="Push-up">Push-up</option>
                            <option value="Burpee">Burpee</option>
                            <option value="Squat">Squat</option>
                            <option value="Grunches">Grunches</option>
                        </select>
                    </label><br>
                    <p class="msg">Select repetitions:<br></p>
                    <input name="repetitions" type="radio" id="one" value="One" v-model="repetitions">
                    <label for="one">One</label>
                    <br>
                    <input name="repetitions" type="radio" id="two" value="Two" v-model="repetitions">
                    <label for="two">Two</label>
                    <br>

                    <input type="submit" value="Add exercise" class="btn">
                    <br>
                    <p class="msg">Selected: {{ name }}</p>
                    <p class="msg">Picked: {{ repetitions }}</p>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import Navigation from '../components/Navigation.vue';
    export default {
        name: "AddExercise",
        components: {
            Navigation
        },
        data() {
            return {
                name: '',
                repetitions: '',
                msg: '',
            }
        },
        methods: {
            addExercise() {
                //this.$emit('addExercise', newExercise);
                axios
                    .post('http://localhost:8080/workouts', {
                        name: this.name,
                        repetitions: this.repetitions,
                    })
                    .then((response => {
                        if (response.status === 200) {
                            this.msg = "Exercise was added";
                        } else {
                            this.msg = "Something went wrong";
                        }
                    }));
            },
        },
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
        background: rgba(32, 32, 32, 0.73);
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
        color: rgb(162, 162, 162);
        font-size: 18px;
    }
    .create-button {
        color: #a24444;
        text-decoration: none;
        font-size: 12px;
        /* #a24444;*/
        /*background-color: rgba(0, 0, 0, 0.77);*/
    }
    .create-button:hover {
        color: #ffffff;
    }
    .login-button {
        cursor: pointer;
        text-decoration: none;
        /* Button height(vertical) and length(horiz)*/
        padding: 6px 80px;
        /* up, right, bottom, left*/
        margin: 10px 0 5px 0;
        border-radius: 45px;
        border: 0;
        /* Make the buttons appear below each other  OTHER OPTION display: inline-block;*/
        background-color: rgba(0, 0, 0, 0.77);
        color: #ffffff;
        font-size: 22px;
    }
    .login-button:hover {
        background-color: #e6e6e6;
        color: #000000;
    }
</style>