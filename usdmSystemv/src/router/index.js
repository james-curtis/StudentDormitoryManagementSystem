// eslint-disable-next-line no-unused-vars
import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "@/views/Login";

import Layout from "@/views/Layout";
import Home from "@/components/Home";
import User from "@/components/User";
import Build from "@/components/Build";
import Dormitory from "@/components/Dormitory";
import Employee from "@/components/Employee";
import StudentInfo from "@/components/StudentInfo";
import AccessRegistration from "@/components/AccessRegistration";
import SelfInfo from "@/components/SelfInfo";

Vue.use(VueRouter)

const routes = [

    {
        path: '/Layout',
        name: 'Layout',
        component: Layout,
        redirect: '/Home',
        children: [
            {
                path: '/Home',
                name: 'Home',
                component: Home,
            },
            {
                path: '/User',
                name: 'User',
                component: User,
            },
            {
                path: '/Build',
                name: 'Build',
                component: Build,
            },

            {
                path: '/Dormitory',
                name: 'Dormitory',
                component: Dormitory,
            },
            {
                path: '/Employee',
                name: 'Employee',
                component: Employee,
            },
            {
                path: '/StudentInfo',
                name: 'StudentInfo',
                component: StudentInfo,
            },
            {
                path: '/AccessRegistration',
                name: 'AccessRegistration',
                component: AccessRegistration,
            },
            {
                path: '/SelfInfo',
                name: 'SelfInfo',
                component: SelfInfo
            }


        ]

    },
    {
        path: '/',
        name: 'Login',
        component: Login,


    },

]

const router = new VueRouter({
    // mode: 'history',
    routes
})

export default router
