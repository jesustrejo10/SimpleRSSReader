package com.jesustrejo10.simplerssreader.model.usecases

import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import com.jesustrejo10.simplerssreader.data.local.entities.Movie
import com.jesustrejo10.simplerssreader.data.remote.repository.MoviesRepository
import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse
import com.jesustrejo10.simplerssreader.model.exception.MoviesException
import com.jesustrejo10.simplerssreader.model.viewData.GetMovieListContainer
import com.jesustrejo10.simplerssreader.model.viewData.SourceType
import java.lang.Exception
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
        private val localDataSource : MovieDao,
        private val remoteDataSource : MoviesRepository
): BaseAsyncUseCase<Unit, UseCaseResult<GetMovieListContainer>>() {


    /**
     * Async use cases might need to return a response to layer above, so doing this it will be available.
     */
    override suspend fun invoke(entry: Unit): UseCaseResult<GetMovieListContainer> {
        var movieList : List<com.jesustrejo10.simplerssreader.model.data.response.Movie>
        var sourceType = SourceType.INTERNET
        var message = ""
        try {
            movieList = remoteDataSource.getMovies().results
            val moviesToDb = movieList.toDbMovies()
            localDataSource.insert(moviesToDb)
        }catch (e : MoviesException){
            movieList = localDataSource.getMovies().toUiMovies()
            sourceType = SourceType.CACHE
            message = e.messageToView
        }catch (e : Exception){
            return UseCaseResult.error(e.message ?: "Unexpected Error, please contact support.")
        }
        return UseCaseResult.success(GetMovieListContainer(sourceType,movieList,message))
    }

}

private fun List<Movie>.toUiMovies(): List<com.jesustrejo10.simplerssreader.model.data.response.Movie> {

    val output = ArrayList<com.jesustrejo10.simplerssreader.model.data.response.Movie>()
    forEach {
        output.add(it.toUiMovie())
    }
    return output
}

private fun List<com.jesustrejo10.simplerssreader.model.data.response.Movie>.toDbMovies() : List<Movie>{

    val output = ArrayList<Movie>()
    forEach {
        output.add(it.toDbMovie())
    }
    return output
}

private fun Movie.toUiMovie() : com.jesustrejo10.simplerssreader.model.data.response.Movie {
    return com.jesustrejo10.simplerssreader.model.data.response.Movie(
            adult ?: false,
            backdropPath ?: "",
            id!!,
            overview ?: "",
            releaseDate ?: "",
            title ?: "",
            voteAverage ?: 0.0,
            voteCount ?: 0
    )
}

private fun com.jesustrejo10.simplerssreader.model.data.response.Movie.toDbMovie() : Movie {
    return Movie(
        id,title,release_date,
        backdrop_path,
        overview,
        vote_average,
        vote_count,
        adult
    )
}
