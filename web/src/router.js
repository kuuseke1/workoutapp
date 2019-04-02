import Vue from 'vue';
import App from './App';
import Router from 'vue-router';
import WelcomePage from './views/Home.vue';
import AddExercise from "./views/AddExercise";
import Registration from "./views/Registration";
import LandingPage from "./views/LandingPage";
import Home from "./views/Home";
import Login from "./views/Login";

Vue.use(Router);


export default new Router({
    routes: [
        {
            path: '/',
            name: 'landing',
            component: LandingPage
        },
        {
            path: '/home',
            name: 'Home',
            component: Home
        },
        {
            path: '/addExercise',
            name: 'AddExercise',
            component: AddExercise
        },
        {
            path: '/register',
            component: Registration
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        }
    ]
});