import gulp from 'gulp';
import util from 'gulp-util';
import path from 'path';
import webpack from 'webpack';
import webpackConfig from './webpack.config.js';
import WebpackDevServer from 'webpack-dev-server';

gulp.task('webpack:build', () => {
  webpack(webpackConfig).run(function (err, stats) {
    if (err) throw new gutil.PluginError('webpack:build', err);
    util.log('[webpack:build]', stats.toString({
      colors: true
    }));
  });
});

gulp.task('webpack:dev-server', ['webpack:build'], function () {
  new WebpackDevServer(webpack(webpackConfig), {
    stats: {
      colors: true
    },
    contentBase: [path.resolve(__dirname, './src')],
  }).listen(3000, 'localhost', (err) => {
    if (err) throw new util.PluginError('webpack:dev-server', err);
    util.log('[webpack-dev-server]', 'Is going to run on: http://localhost:3000');
  });
});
