package com.jesustrejo10.simplerssreader.model.usecases

import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import com.jesustrejo10.simplerssreader.data.local.entities.Movie
import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
        private val localDataSource : MovieDao
): BaseAsyncUseCase<Unit, UseCaseResult<GetMoviesResponse>>() {


    /**
     * Async use cases might need to return a response to layer above, so doing this it will be available.
     */
    override suspend fun invoke(entry: Unit): UseCaseResult<GetMoviesResponse> {

        val movieList = localDataSource.getMovies().toUiMovies()
        return UseCaseResult.success(GetMoviesResponse(movieList))
    }
}

private fun List<Movie>.toUiMovies(): List<com.jesustrejo10.simplerssreader.model.data.response.Movie> {

    val output = ArrayList<com.jesustrejo10.simplerssreader.model.data.response.Movie>()
    forEach {
        output.add(it.toUiMovie())
    }
    return output
}

private fun Movie.toUiMovie() : com.jesustrejo10.simplerssreader.model.data.response.Movie {
    return com.jesustrejo10.simplerssreader.model.data.response.Movie(
            adult ?: false,
            backdropPath ?: "",
            id!!,
            originalLanguage ?: "en",
            originalTitle ?: "",
            overview ?: "",
            popularity?: 0.0,
            posterPath ?: "",
            releaseDate ?: "",
            title ?: "",
            voteAverage ?: 0.0,
            voteCount ?: 0
    )
}
