//
//  MovieListScreen.swift
//  iosApp
//
//  Created by Sa7ar Nollily on 11/07/1443 AH.
//  Copyright © 1443 orgName. All rights reserved.
//

import SwiftUI
import shared


struct MovieListScreen: View {
    
    @ObservedObject var movieListViewModel: MovieListViewModel = MovieListViewModel()
    
    var body: some View {

        VStack{

            switch true {
            case movieListViewModel.movieListState.isLoading: getProgrsssBar()
            case movieListViewModel.movieListState.data.count != 0 : getMovieListView()
            case !movieListViewModel.movieListState.error.isEmpty: getErrorButton()
            default: getProgrsssBar()

            }
        }
        
        
        
    }
    
    @ViewBuilder private func getMovieListView() -> some View {
        List(){
            ForEach(self.movieListViewModel.movieListState.data, id: \.self.name){
                movie in
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string: "https://image.tmdb.org/t/p/original\(movie.posterPath)")){ image in
                        image.resizable()
                    } placeholder: {
                        getProgrsssBar()
                    }.frame(width: .infinity, height: 500)
                } else {
                    // Fallback on earlier versions
                }
                    Text(movie.name)
                        .padding(.all, 20.0)
                    }
                }
    }
    
    @ViewBuilder private func getProgrsssBar() -> some View {
        ProgressView()
            .frame(maxWidth: .infinity, alignment: .center)
            .padding(.top, 10)
            .scaleEffect(1.2)
    }
    
    
    @ViewBuilder private func getErrorButton() -> some View {
        Button(self.movieListViewModel.movieListState.error,
               action: self.movieListViewModel.getMovie)
    }
    
    

}
   
