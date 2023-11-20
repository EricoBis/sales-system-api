import { authConfig } from "@/lib/auth";
import { API_URL } from "@/services/api-url";
import NextAuth from "next-auth"
import CredentialsProvider from "next-auth/providers/credentials";

const handler = NextAuth(authConfig);

export { handler as GET, handler as POST }