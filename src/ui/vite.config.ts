import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import { resolve } from 'path';
const root = resolve(__dirname, 'src');
const outDir = resolve(__dirname, 'dist');

export default defineConfig({
	plugins: [react()],
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
