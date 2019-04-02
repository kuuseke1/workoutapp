<template>
    <div class="wrapper">
        <div class="login-box">
            <div class="form">
                <form class="login-form">
                    <input type="text" placeholder="username" name="username" v-model="input.username">
                    <input type="password" placeholder="password" name="password" v-model="input.password">
                    <button class="login-button" v-on:click="login()">Login</button>
                </form>
                <p class="msg">Not registered?</p>
                <router-link class="create-button" to="/register">Create an account</router-link>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                input: {
                    username: "",
                    password: ""
                }
            }
        },
        methods: {
            login() {
                if (this.input.username !== "" && this.input.password !== "") {
                    if (this.input.username === this.$parent.mockAccount.username && this.input.password === this.$parent.mockAccount.password) {
                        this.$emit("authenticated", true);
                        this.$router.replace({name: "Home"})
                    } else {
                        alert("The username and/or password is incorrect :(")
                    }
                } else {
                    alert("Fill out username and password!")
                }
            }
        }
    }
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
        -webkit-box-shadow:  20px -3px 300px 200px rgba(255, 255, 255, 0.21);
        -moz-box-shadow:  20px -3px 300px 200px rgba(255, 255, 255, 0.21);
        box-shadow:  20px -3px 300px 2000px rgba(255, 255, 255, 0.21);
        border-radius: 15px;
        /*background: #868686;*/
        border: solid rgba(255, 255, 255, 0.31);
    }
    .form input {
        background: rgba(255, 255, 255, 0.67);
        width: 100%;
        border: 0;
        margin: 0 0 22px;
        padding: 15px;
        box-sizing: border-box;
        font-size: 14px;
        border-radius: 5px;
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