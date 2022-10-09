import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import { resolve } from 'path';
const root = resolve(__dirname, 'src');
const outDir = resolve(__dirname, 'dist');

export default defineConfig({
	plugins: [react()],
	server: {
		port: 3000,
		proxy: {
			'/api': {
				target: 'http://localhost:8080',
				ws: true,
				changeOrigin: true,
			},
		},
	},
	build: {
		outDir,
		emptyOutDir: true,
		cssCodeSplit: true,
		rollupOptions: {
			input: {
				index: resolve('index.html'),
				post: resolve('post.html'),
			},
		},
		polyfillModulePreload: false,
		sourcemap: true,
	},
});
