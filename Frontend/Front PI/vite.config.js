import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  test:{
    globals: true,
    environment: 'jsdom',
    setupFiles: ["./setupTests.js"],
    coverage: {
      provider: "istanbul",
      reporter: [
        "text",
        "json",
        "html"
      ]
    }
  }
})